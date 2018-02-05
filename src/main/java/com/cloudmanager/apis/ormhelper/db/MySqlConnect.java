package com.cloudmanager.apis.ormhelper.db;


import com.cloudmanager.apis.configuration.ExceptionMessages;
import com.cloudmanager.apis.exception.BadRequestException;
import com.cloudmanager.apis.utils.PropertyManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @desc A singleton database access class
 */
public final class MySqlConnect {

    static final Logger logger = Logger.getLogger(MySqlConnect.class);
    public static Connection conn;
    public static MySqlConnect db;

    private static HikariDataSource ds;

    static
    {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(PropertyManager.getSetting("mySQLEndPoint"));
        config.setUsername(PropertyManager.getSetting("dataSourceCode3Manager.username"));
        config.setPassword(PropertyManager.getSetting("dataSourceCode3Manager.password"));
        config.setDriverClassName(PropertyManager.getSetting("mySQLDriver"));
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("verifyServerCertificate", "false");

        ds = new HikariDataSource(config);
    }


    private MySqlConnect() {

        logger.info("Creating a new connection");
        try {

            if(this.conn==null) {

                this.conn = (Connection) ds.getConnection();
                logger.info("MYSQL-INFO: New Connection :" + conn.toString());
            }else
            {
                logger.info("Connection Exist");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BadRequestException(ExceptionMessages.EX_DB_SQLE + e.getMessage());
        }
    }

    public static synchronized MySqlConnect getDatabaseConnection() {
        logger.info("Get Existing MySqlConnect Object");


        if ( db == null ) {
            logger.info("Get New MySqlConnect Object");
            db = new MySqlConnect();
        }
        return db;

    }

    /**
     * @return MySqlConnect Database connection
     */
    public static Connection getConnection()
    {
        logger.info("getConnection()");
        try {
            if(conn==null) {
                conn = (Connection) ds.getConnection();
                logger.info("MYSQL-INFO: Returning New Connection :" + conn.toString());
            }else
            {
                logger.info("MYSQL-INFO: Connection Exist");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BadRequestException(ExceptionMessages.EX_DB_SQLE + e.getMessage());
        }

        logger.info("Returning a existing connection");
        return db.conn;
    }

    /**
     *  Close MySqlConnect Database connection
     */

    public void close()
    {
        if(conn!=null) {
            try {
                logger.info("MYSQL-INFO: Connection Close :" + conn.toString());
                conn.close();
                db.conn =null;
            } catch (SQLException e) {
                logger.info("MYSQL-INFO: Connection Close :" + conn.toString());
                throw new BadRequestException(ExceptionMessages.EX_DB_SQLE + ":NULL Connection:" + e.getMessage());
            }
        }

        logger.info("MYSQL-INFO: Connection was already Null :");
    }

}
