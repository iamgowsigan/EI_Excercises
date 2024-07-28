# Smart Office Facility Programming System

## Overview

This console-based application manages a smart office facility by handling conference room bookings, detecting occupancy, and automating control of air conditioning and lighting based on room occupancy. The system is designed with best coding practices and incorporates several design patterns to ensure efficiency, maintainability, and scalability.

## Functional Requirements

### Mandatory Requirements

1. **Configure Office**: Users can specify the number of meeting rooms.
2. **Room Bookings**: Users can book and cancel bookings for conference rooms.
3. **Occupancy Detection**: The system detects occupancy using sensors that register when at least two people enter a room.
4. **Automatic Booking Release**: Unoccupied rooms automatically release bookings if not occupied within 5 minutes.
5. **Automated Control**: The air conditioning and lights turn off if the room is not occupied.

### Optional Requirements

1. **Room Usage Statistics**: Provide a summary of room usage statistics.
2. **User Authentication**: Restrict access to booking and configuration features.
3. **Notifications**: Notify users via email or SMS when their booked room is released automatically.

## Design Patterns Used

1. **Singleton Pattern**: Ensures a single instance for the office configuration and room booking system.
2. **Observer Pattern**: Sensors and control systems (lights, AC) are observers to the room's occupancy status.
3. **Command Pattern**: Handles bookings, cancellations, and room status updates via commands for flexibility and extensibility.
