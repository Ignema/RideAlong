INSERT INTO
    participant (participant_id, name, phone, email, birthday)
VALUES
       (nextval('participant_sequence'), 'john', 0000, 'john@test', '1999-03-14'),
       (nextval('participant_sequence'), 'jack', 0001, 'jack@test', '1958-08-11'),
       (nextval('participant_sequence'), 'sophie', 0002, 'sophie@test', '2000-04-19'),
       (nextval('participant_sequence'), 'dan', 0003, 'dan@test', '1975-03-28'),
       (nextval('participant_sequence'), 'tim', 0004, 'tim@test', '1989-01-11'),
       (nextval('participant_sequence'), 'linda', 0005, 'linda@test', '2002-08-14'),
       (nextval('participant_sequence'), 'peter', 0006, 'peter@test', '1997-12-18'),
       (nextval('participant_sequence'), 'tom', 0007, 'tom@test', '2002-03-26');

INSERT INTO
    meetup (meetup_id, completed, date, gallery, location)
VALUES
(nextval('meetup_sequence'), false, current_timestamp, 'drive.google.com/drive/u/0/', 'rue blabla'),
(nextval('meetup_sequence'), false, current_timestamp, 'drive.google.com/drive/u/0/', 'ensias'),
(nextval('meetup_sequence'), false, current_timestamp, 'drive.google.com/drive/u/0/', 'inpt'),
(nextval('meetup_sequence'), false, current_timestamp, 'drive.google.com/drive/u/0/', 'gare agdal'),
(nextval('meetup_sequence'), true, current_timestamp, 'drive.google.com/drive/u/0/', 'megamall'),
(nextval('meetup_sequence'), false, current_timestamp, 'drive.google.com/drive/u/0/', 'centreville'),
(nextval('meetup_sequence'), false, current_timestamp, 'drive.google.com/drive/u/0/', 'cote'),
(nextval('meetup_sequence'), false, current_timestamp, 'drive.google.com/drive/u/0/', '9amra');

INSERT INTO
    bicycle (bicycle_id, available, duration, image, model, price)
VALUES
(nextval('bicycle_sequence'), true, 7, 'https://images.unsplash.com/photo-1485965120184-e220f721d03e', '3T Explore', 200),
(nextval('bicycle_sequence'), false, 2, 'https://images.unsplash.com/photo-1571068316344-75bc76f77890', 'Alchemy', 150),
(nextval('bicycle_sequence'), true, 4, 'https://images.unsplash.com/photo-1511994298241-608e28f14fde', 'All-City', 300),
(nextval('bicycle_sequence'), false, 8, 'https://images.unsplash.com/photo-1576435728678-68d0fbf94e91', 'Ancheer', 150),
(nextval('bicycle_sequence'), true, 2, 'https://images.unsplash.com/uploads/14122621859313b34d52b/37e28531', 'Bianchi', 150),
(nextval('bicycle_sequence'), true, 7, 'https://images.unsplash.com/photo-1532298229144-0ec0c57515c7', 'Cannondale', 200),
(nextval('bicycle_sequence'), true, 10, 'https://images.unsplash.com/photo-1505705694340-019e1e335916', 'Colnago', 250),
(nextval('bicycle_sequence'), true, 30, 'https://images.unsplash.com/photo-1553105659-d918b253f0f2', 'Retrospec Cycles', 500);

INSERT INTO
    message (message_id, content, date)
VALUES
(nextval('message_sequence'), 'Hi', current_timestamp),
(nextval('message_sequence'), 'Hello', current_timestamp),
(nextval('message_sequence'), 'How are you?', current_timestamp),
(nextval('message_sequence'), 'Where are we going?', current_timestamp),
(nextval('message_sequence'), 'How much time is it going to be?', current_timestamp),
(nextval('message_sequence'), 'About 2 hours...', current_timestamp),
(nextval('message_sequence'), 'Okey thanks!', current_timestamp),
(nextval('message_sequence'), 'It was fun everyone!!', current_timestamp);

INSERT INTO
    message_meetup (meetup_id, message_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8);

INSERT INTO
    organizer (participant_id, meetup_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(3, 6),
(3, 7),
(3, 8);

INSERT INTO
    "owner" (participant_id, bicycle_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8);

INSERT INTO
    participant_meetup (participant_id, meetup_id)
VALUES
(1, 6),
(1, 7),
(1, 8),
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(3, 5);
