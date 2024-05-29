-- Insert sample data for the User model
INSERT INTO USERS (username, email, password, is_admin, enabled)
VALUES
    ('john_doe', 'john.doe@example.com', 'password123', true, true),
    ('jane_smith', 'jane.smith@example.com', 'password123', false, true),
    ('bob_jackson', 'bob.jackson@example.com', 'password123', false, true);