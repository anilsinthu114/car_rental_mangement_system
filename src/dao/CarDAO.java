package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Car;
import Database_conn.DBUtil;

public class CarDAO {
    // Method to add a new car to the database
    public static boolean addCar(Car car) {
        boolean success = false;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "INSERT INTO Car (make, model, year, rental_rate_per_day, availability_status) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, car.getMake());
            stmt.setString(2, car.getModel());
            stmt.setInt(3, car.getYear());
            stmt.setDouble(4, car.getRentalRatePerDay());
            stmt.setString(5, car.getAvailabilityStatus());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Print the error to the webpage
                    } finally {
            DBUtil.close(conn, stmt, null);
        }
        return success;
    }
   
    // Method to retrieve all cars from the database
    public static List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM Car";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Iterate through the result set and create Car objects
            while (rs.next()) {
                Car car = new Car();
                car.setCarId(rs.getInt("car_id"));
                car.setMake(rs.getString("make"));
                car.setModel(rs.getString("model"));
                car.setYear(rs.getInt("year"));
                car.setRentalRatePerDay(rs.getDouble("rental_rate_per_day"));
                car.setAvailabilityStatus(rs.getString("availability_status"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Print the error to the webpage
            
        } finally {
            DBUtil.close(conn, stmt, rs);
        }

        return cars;
    }
    
    // Method to retrieve a car by its ID from the database
    public static Car getCarById(int carId) {
        Car car = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM Car WHERE car_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, carId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                car = new Car();
                car.setCarId(rs.getInt("car_id")); // Corrected column name
                car.setMake(rs.getString("make"));
                car.setModel(rs.getString("model"));
                car.setYear(rs.getInt("year"));
                car.setRentalRatePerDay(rs.getDouble("rental_rate_per_day"));
                car.setAvailabilityStatus(rs.getString("availability_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Print the error to the webpage
            
        } finally {
            DBUtil.close(conn, stmt, rs);
        }

        return car;
    }
    
    // Method to update a car record by ID
    public static boolean updateCarById(int carId, Car updatedCar) {
        boolean success = false;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE Car SET make=?, model=?, year=?, rental_rate_per_day=?, availability_status=? WHERE car_id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, updatedCar.getMake());
            stmt.setString(2, updatedCar.getModel());
            stmt.setInt(3, updatedCar.getYear());
            stmt.setDouble(4, updatedCar.getRentalRatePerDay());
            stmt.setString(5, updatedCar.getAvailabilityStatus());
            stmt.setInt(6, carId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
           
        } finally {
            DBUtil.close(conn, stmt, null);
        }
        return success;
    }
    
    // Method to delete a car record by ID
    public static boolean deleteCarById(int carId, PrintWriter out) {
        boolean success = false;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "DELETE FROM Car WHERE car_Id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, carId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Print the error to the webpage
            printErrorToWebpage(e, out);
        } finally {
            DBUtil.close(conn, stmt, null);
        }
        return success;
    }

    // Method to print the error to the webpage
    private static void printErrorToWebpage(SQLException e, PrintWriter out) {
        // Assuming you have access to PrintWriter object, you can write the error message to the response
        out.println("<p>Error occurred: " + e.getMessage() + "</p>");
    }
}
