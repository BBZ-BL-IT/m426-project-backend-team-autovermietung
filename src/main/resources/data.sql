-- Insert sample data for the User model
INSERT INTO users (username, email, password, is_admin, enabled)
VALUES
    ('john_doe', 'john.doe@example.com', 'password123', true, true),
    ('jane_smith', 'jane.smith@example.com', 'password123', false, true),
    ('bob_jackson', 'bob.jackson@example.com', 'password123', false, true);

-- Sample Data for the car model
INSERT INTO cars (brand, model, color, license_plate, mileage, engine_power, fuel_type, number_of_seats, rental_price, consumption, enabled)
VALUES
    ('Volkswagen', 'Golf', 'Blue', 'ABC123', 20000, 110, 'Petrol', 5, 45, 5, true),
    ('BMW', '3 Series', 'Black', 'DEF456', 15000, 150, 'Diesel', 5, 65, 4, true),
    ('Audi', 'A4', 'White', 'GHI789', 18000, 140, 'Petrol', 5, 55, 5.2, true),
    ('Mercedes-Benz', 'C-Class', 'Silver', 'JKL012', 22000, 160, 'Diesel', 5, 75, 5, true),
    ('Toyota', 'Yaris', 'Red', 'MNO345', 12000, 90, 'Hybrid', 5, 35, 3, true),
    ('Ford', 'Fiesta', 'Green', 'PQR678', 25000, 95, 'Petrol', 5, 40, 5, true);