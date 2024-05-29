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


-- Sample Data for the rentals
INSERT INTO rentals (car_id, user_id, rental_start, rental_end, total_cost, status)
VALUES
    (1, 1, '2024-06-01', '2024-06-10', 459, 'completed'),
    (2, 2, '2024-07-01', '2024-07-15', 989, 'active'),
    (3, 3, '2024-08-01', '2024-08-07', 391, 'reserved'),
    (4, 1, '2024-09-01', '2024-09-05', 379, 'completed'),
    (5, 2, '2024-10-01', '2024-10-20', 719, 'active'),
    (6, 3, '2024-11-01', '2024-11-10', 409, 'reserved');
