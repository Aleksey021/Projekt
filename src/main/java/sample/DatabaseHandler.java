import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }
    public void signUpUser(User user){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USERS_NAME + "," +
                Const.USERS_LASTNAME + "," +
                Const.USERS_PASSVORD + "," +
                Const.USER_LOGIN + "," +
                Const.USER_STRANA + "," +
                Const.USER_EMAIL +")" +
                "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getName());
            prSt.setString(2, user.getLastname());
            prSt.setString(3, user.getPassvord());
            prSt.setString(4, user.getLogin());
            prSt.setString(5, user.getStrana());
            prSt.setString(6, user.getEmail());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_LOGIN + "=? AND " + Const.USERS_PASSVORD + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassvord());

           resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }


    /*public ResultSet getUser2(User user) {
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_NAME + "=? AND " + Const.USERS_LASTNAME + "=? AND " +
                Const.USER_EMAIL + "=? AND " + Const.USER_LOGIN + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getName());
            prSt.setString(2, user.getLastname());
            prSt.setString(3, user.getEmail());
            prSt.setString(4, user.getLogin());

            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSet;
    }*/

    public ResultSet getMountain(Mountain mountain) {
        ResultSet resSet = null;

        String select = "SELECT * FROM mountans WHERE vershina=? AND visota=? AND mestopoloqenie=? AND sistema=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, mountain.getVershina());
            prSt.setInt(2, mountain.getVisota());
            prSt.setString(3, mountain.getMestopoloqenie());
            prSt.setString(4, mountain.getSistema());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }
}
