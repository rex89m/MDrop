package pl.rex89m.mdrop.Baza;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Player.PlayerSettings;
import pl.rex89m.mdrop.Stoniarka.Stoniarka;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class SQL {

    public final MDrop plugin;

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:plugins/MDrop/BazaDanych.db";

    private Connection conn;
    private Statement stat;

    public SQL(MDrop plugin) {
        this.plugin = plugin;
        load();
    }

    public void load() {
        try {
            Class.forName(SQL.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
        createTables();
    }

    public boolean createTables()  {
        String TopOpenChest = "CREATE TABLE IF NOT EXISTS TopOpenChest (ID INTEGER PRIMARY KEY AUTOINCREMENT, nick varchar(255), uuid varchar(255), case_id varchar(255), ilosc int)";
        String Stoniarka = "CREATE TABLE IF NOT EXISTS Stoniarka (ID INTEGER PRIMARY KEY AUTOINCREMENT, location varchar(255))";
        String Settings = "CREATE TABLE IF NOT EXISTS Settings (ID INTEGER PRIMARY KEY AUTOINCREMENT, nick varchar(255), uuid varchar(255), dropvalue varchar(255), cobblestone varchar(255))";

        try {
            stat.execute(TopOpenChest);
            stat.execute(Stoniarka);
            stat.execute(Settings);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void addLocationStoniarka(Location l){
        String var = l.getWorld().getName()+"#"+l.getBlockX()+"#"+l.getBlockY()+"#"+l.getBlockZ();
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Stoniarka values (NULL, ?);");
            prepStmt.setString(1, var);
            prepStmt.execute();
            Stoniarka.addLocation(l);
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu Stoniarki");
            e.printStackTrace();
        }
    }

    public void addSettingsPlayer(Player p, String settings){
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Settings values (NULL, ?,?,?,?);");
            prepStmt.setString(1, p.getName());
            prepStmt.setString(2, p.getUniqueId().toString());
            prepStmt.setString(3, settings);
            prepStmt.setString(4, String.valueOf(true));

            prepStmt.execute();
            PlayerSettings playerSettings = new PlayerSettings(p);
            playerSettings.setDrop(settings);
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu settings");
            e.printStackTrace();
        }
    }
    public void removeSettingsPlayer(Player p){
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "DELETE FROM Settings WHERE uuid='"+p.getUniqueId()+"'");
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu settings");
            e.printStackTrace();
        }
    }


    public void rmoveLocationStoniarka(Location l){
        String var = l.getWorld().getName()+"#"+l.getBlockX()+"#"+l.getBlockY()+"#"+l.getBlockZ();
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "DELETE FROM Stoniarka WHERE location='"+var+"';");
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy usuwaniu Stoniarki");
            e.printStackTrace();
        }
    }

    public HashMap<Location, Boolean> getAllStoniarka() {
        HashMap<Location, Boolean> var = new HashMap<>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Stoniarka");
            while(result.next()) {
                String[] varloc = result.getString("location").split("#");
                var.put(new Location(Bukkit.getWorld(varloc[0]), Integer.parseInt(varloc[1]), Integer.parseInt(varloc[2]), Integer.parseInt(varloc[3])), true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return var;
        }
        return var;
    }

    public PlayerSettings loadPlayerSettings(Player p){
        PlayerSettings playerSettings = null;
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Settings WHERE uuid='"+p.getUniqueId()+"'");
            while(result.next()) {
                playerSettings = new PlayerSettings(p);
                playerSettings.setDrop(result.getString("dropvalue"));
                playerSettings.setCobblestone(result.getBoolean("cobblestone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerSettings;
    }


    public boolean inserPlayerTopCase(String nick, String caseNazwa) {
        if (!hasPlayerCaseTop(nick, caseNazwa)) {
            try {
                PreparedStatement prepStmt = conn.prepareStatement(
                        "insert into TopOpenChest values (NULL, ?, ?, ?, 0);");
                prepStmt.setString(1, nick);
                prepStmt.setString(2, Bukkit.getPlayer(nick).getUniqueId().toString());
                prepStmt.setString(3, caseNazwa);
                prepStmt.execute();
            } catch (SQLException e) {
                System.err.println("Blad przy wstawianiu gracza " + nick);
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean updateSettingsDrop(Player p, String update) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "UPDATE Settings SET dropvalue='"+update+"' WHERE uuid='"+p.getUniqueId()+"';");
            prepStmt.execute();
            PlayerSettings.get(p.getUniqueId()).setDrop(update);
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu settings");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean updateSettingsDropCobblestone(Player p, Boolean bolean) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "UPDATE Settings SET cobblestone='"+bolean+"' WHERE uuid='"+p.getUniqueId()+"';");
            prepStmt.execute();
            PlayerSettings.get(p.getUniqueId()).setCobblestone(bolean);
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu settings");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean addTopPlayerCase(String nick, String caseNazwa) {
        try {
            int liczba = getTopPlayerCase(Bukkit.getPlayer(nick), caseNazwa);
            PreparedStatement prepStmt = conn.prepareStatement(
                    "UPDATE TopOpenChest SET ilosc='"+(liczba+1)+"' WHERE uuid='"+Bukkit.getPlayer(nick).getUniqueId()+"' AND case_id='"+caseNazwa+"';");
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu gracza "+nick);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Integer getTopPlayerCase(Player p, String caseNazwa) {
        int var = 0;
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM TopOpenChest WHERE uuid = '"+p.getUniqueId()+"' AND case_id = '"+caseNazwa+"'");
            while(result.next()) {
                var = result.getInt("ilosc");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return var;
    }

    public HashMap<String, Integer> getAllTopPlayerCase(String caseNazwa) {
        HashMap<String, Integer> var = new HashMap<>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM TopOpenChest WHERE case_id = '"+caseNazwa+"'");
            while(result.next()) {
                var.put(result.getString("nick"), result.getInt("ilosc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return var;
    }


    private boolean hasTopPlayerCase(String p) {
        String var = "";
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM TopOpenChest WHERE nick = '"+p+"'");
            while(result.next()) {
                var = result.getString("nick");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        boolean var2 = false;
        if (!var.equals("")){
            var2=true;
        }
        return var2;
    }

    private boolean hasPlayerCaseTop(String p, String casename) {
        String var = "";
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM TopOpenChest WHERE case_id = '"+casename+"' AND nick = '"+p+"'");
            while(result.next()) {
                var = result.getString("case_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        boolean var2 = false;
        if (!var.equals("")){
            var2=true;
        }
        return var2;
    }

}
