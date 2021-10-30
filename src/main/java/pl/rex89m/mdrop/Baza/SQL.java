package pl.rex89m.mdrop.Baza;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import pl.rex89m.mdrop.Ban.Ban;
import pl.rex89m.mdrop.Ban.BanInfo;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Player.PlayerSettings;
import pl.rex89m.mdrop.Stoniarka.Stoniarka;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

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
        getPlayerbanInfo(Bukkit.getPlayer("rex89m"));
    }

    public boolean createTables()  {
        String TopOpenChest = "CREATE TABLE IF NOT EXISTS TopOpenChest (ID INTEGER PRIMARY KEY AUTOINCREMENT, nick varchar(255), uuid varchar(255), case_id varchar(255), ilosc int)";
        String Stoniarka = "CREATE TABLE IF NOT EXISTS Stoniarka (ID INTEGER PRIMARY KEY AUTOINCREMENT, location varchar(255))";
        String Stoniarkaplus = "CREATE TABLE IF NOT EXISTS Stoniarkaplus (ID INTEGER PRIMARY KEY AUTOINCREMENT, location varchar(255))";
        String Settings = "CREATE TABLE IF NOT EXISTS Settings (ID INTEGER PRIMARY KEY AUTOINCREMENT, nick varchar(255), uuid varchar(255), dropvalue varchar(255), cobblestone varchar(255))";
        String historia = "CREATE TABLE IF NOT EXISTS history (ID INTEGER PRIMARY KEY AUTOINCREMENT, nick varchar(255), uuid varchar(255), reason varchar(255), time varchar(255), date varchar(255), typ varchar(255), owner varchar(255))";
        String ban = "CREATE TABLE IF NOT EXISTS ban (ID INTEGER PRIMARY KEY AUTOINCREMENT, nick varchar(255), uuid varchar(255), reason varchar(255), time varchar(255), date varchar(255), owner varchar(255))";
        String mute = "CREATE TABLE IF NOT EXISTS mute (ID INTEGER PRIMARY KEY AUTOINCREMENT, nick varchar(255), uuid varchar(255), reason varchar(255), time varchar(255),date varchar(255), owner varchar(255))";

        try {
            stat.execute(TopOpenChest);
            stat.execute(Stoniarka);
            stat.execute(Settings);
            stat.execute(Stoniarkaplus);
            stat.execute(historia);
            stat.execute(mute);
            stat.execute(ban);

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
            System.err.println("Blad przy dodawaniu Stoniarka");
            e.printStackTrace();
        }
    }
    public void addbanPlayer(Player p,Player target, String reason, Date time){
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into ban values (NULL, ?, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, target.getName());
            prepStmt.setString(2, target.getUniqueId().toString());
            prepStmt.setString(3, reason);
            prepStmt.setLong(4, time.getTime());
            prepStmt.setString(5,simpleDateFormat.format(c.getTime()));
            prepStmt.setString(6, p.getName());
            prepStmt.execute();
            addhistoryPlayer(p, target, reason, time, "BAN");
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu bana");
            e.printStackTrace();
        }
    }
    public void addbanPlayer(ConsoleCommandSender p, Player target, String reason, Date time){
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into ban values (NULL, ?, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, target.getName());
            prepStmt.setString(2, target.getUniqueId().toString());
            prepStmt.setString(3, reason);
            prepStmt.setLong(4, time.getTime());
            prepStmt.setString(5,simpleDateFormat.format(c.getTime()));
            prepStmt.setString(6, p.getName());
            prepStmt.execute();
            addhistoryPlayer(p, target, reason, time, "BAN");
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu bana");
            e.printStackTrace();
        }
    }


    public void addmutePlayer(Player p,Player target, String reason, Date time){
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into mute values (NULL, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, target.getName());
            prepStmt.setString(2, target.getUniqueId().toString());
            prepStmt.setString(3, reason);
            prepStmt.setLong(4, time.getTime());
            prepStmt.setString(5,simpleDateFormat.format(c.getTime()));
            prepStmt.setString(6, p.getName());
            prepStmt.execute();
            addhistoryPlayer(p, target, reason, time, "MUTE");
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu bana");
            e.printStackTrace();
        }
    }


    public void addhistoryPlayer(Player p,Player target, String reason, Date time, String typ){
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into history values (NULL, ?, ?, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, target.getName());
            prepStmt.setString(2, target.getUniqueId().toString());
            prepStmt.setString(3, reason);
            prepStmt.setLong(4, time.getTime());
            prepStmt.setString(5, simpleDateFormat.format(c.getTime()));
            prepStmt.setString(6, typ);
            prepStmt.setString(7, p.getName());

            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu histori");
            e.printStackTrace();
        }
    }
    public void addhistoryPlayer(ConsoleCommandSender p,Player target, String reason, Date time, String typ){
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into history values (NULL, ?, ?, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, target.getName());
            prepStmt.setString(2, target.getUniqueId().toString());
            prepStmt.setString(3, reason);
            prepStmt.setLong(4, time.getTime());
            prepStmt.setString(5, simpleDateFormat.format(c.getTime()));
            prepStmt.setString(6, typ);
            prepStmt.setString(7, p.getName());

            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu histori");
            e.printStackTrace();
        }
    }


    public void addhistoryPlayer(Player p,Player target, String reason, String time, String typ){
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into history values (NULL, ?, ?, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, target.getName());
            prepStmt.setString(2, target.getUniqueId().toString());
            prepStmt.setString(3, reason);
            prepStmt.setString(4, time);
            prepStmt.setString(5, simpleDateFormat.format(c.getTime()));
            prepStmt.setString(6, typ);
            prepStmt.setString(7, p.getName());
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu histori");
            e.printStackTrace();
        }
    }
    public void addhistoryPlayer(ConsoleCommandSender p,Player target, String reason, String time, String typ){
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into history values (NULL, ?, ?, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, target.getName());
            prepStmt.setString(2, target.getUniqueId().toString());
            prepStmt.setString(3, reason);
            prepStmt.setString(4, time);
            prepStmt.setString(5, simpleDateFormat.format(c.getTime()));
            prepStmt.setString(6, typ);
            prepStmt.setString(7, p.getName());
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu histori");
            e.printStackTrace();
        }
    }

    public boolean hasPlayerban(Player p){
        boolean var = false;
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM ban WHERE uuid='"+p.getUniqueId()+"'");
            while(result.next()) {
                if (!result.getString("reason").equals("") || result.getString("reason")!=null){
                    var=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return var;
        }
        return var;
    }

    public HashMap<Ban, String> getPlayerban(Player p){
        HashMap<Ban, String> var = new HashMap<>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM ban WHERE uuid='"+p.getUniqueId()+"'");
            while(result.next()) {
                var.put(Ban.playername, result.getString("nick"));
                var.put(Ban.time, result.getString("time"));
                var.put(Ban.reason, result.getString("reason"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return var;
        }
        return var;
    }

    public BanInfo getPlayerbanInfo(Player p){
        BanInfo ban = new BanInfo();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM ban WHERE uuid='"+p.getUniqueId()+"'");
            while(result.next()) {
                ban.setPlayer(p);
                ban.setSender(result.getString("owner"));
                Calendar calendar = Calendar.getInstance();
                String[] var2 = result.getString("date").split(" ");
                String[] var3 = var2[0].split("-");
                String[] var4 = var2[1].split(":");
                calendar.set(Calendar.YEAR, Integer.parseInt(var3[0]));
                calendar.set(Calendar.MONTH, Integer.parseInt(var3[1])-1);
                calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(var3[2]));
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(var4[0]));
                calendar.set(Calendar.MINUTE, Integer.parseInt(var4[1]));
                calendar.set(Calendar.SECOND, Integer.parseInt(var4[2]));
                ban.setDateCreated(calendar.getTime());
                ban.setDateend(new Date(result.getLong("time")));
                ban.setReason(result.getString("reason"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ban;
        }
        return ban;
    }


    public void removePlayerban(Player p){
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "DELETE FROM ban WHERE uuid='"+p.getUniqueId()+"'");
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy usuwaniu ban");
            e.printStackTrace();
        }
    }

    public void addLocationStoniarkaplus(Location l){
        String var = l.getWorld().getName()+"#"+l.getBlockX()+"#"+l.getBlockY()+"#"+l.getBlockZ();
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Stoniarkaplus values (NULL, ?);");
            prepStmt.setString(1, var);
            prepStmt.execute();
            Stoniarka.addLocation(l, true);
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu Stoniarka plus");
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
            System.err.println("Blad przy usuwaniu settings");
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
        Stoniarka.removeStoniarka(l);
    }

    public void rmoveLocationStoniarkaplus(Location l){
        String var = l.getWorld().getName()+"#"+l.getBlockX()+"#"+l.getBlockY()+"#"+l.getBlockZ();
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "DELETE FROM Stoniarkaplus WHERE location='"+var+"';");
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy usuwaniu Stoniarki plus");
            e.printStackTrace();
        }
        Stoniarka.removeStoniarka(l, true);
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

    public HashMap<Location, Boolean> getAllStoniarkaplus() {
        HashMap<Location, Boolean> var = new HashMap<>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Stoniarkaplus");
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
