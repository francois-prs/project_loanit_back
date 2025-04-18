INSERT INTO cat_equipment (name_cat_equipment)
VALUES ('Computers'),
       ('Peripherals'),
       ('Displays'),
       ('Storage'),
       ('Networking'),
       ('Specialised Hardware'),
       ('VR Headset');

INSERT INTO condition_equipment (id_condition_equipment, name_condition_equipment)
VALUES ('A01', 'Excellent'),
       ('B02', 'Good'),
       ('C03', 'Fair'),
       ('D04', 'Poor'),
       ('E05', 'Broken');

INSERT INTO profil_equipment (id_profil_equipment, name_profil_equipment)
VALUES ('X', 'Standard'),
       ('Y', 'Professional'),
       ('Z', 'Premium');

INSERT INTO status_equipment (name_status_equipment)
VALUES ('Available'),
       ('In Use'),
       ('Under Repair'),
       ('Reserved');

INSERT INTO equipment (id_equipment, name_equipment, description_equipment, serial_num_equipment,
                       purchasedate_equipment, id_cat_equipment, id_status_equipment, id_condition_equipment,
                       id_profil_equipment)
VALUES ('EQ001', 'Dell XPS 15 Laptop', 'High-performance developer laptop', 'XPS15-9560-A7842', '2023-05-15', 1, 1,
        'A01', 'X'),
       ('EQ002', 'Canon EOS 5D Mark IV', 'Professional DSLR camera', 'CN5478923145', '2022-11-03', 2, 2, 'A01', 'Y'),
       ('EQ003', 'iPad Pro 12.9"', 'Latest model with Apple Pencil', 'IPAD97531XCV', '2023-08-22', 1, 3, 'B02', 'Z'),
       ('EQ004', 'Logitech MX Master 3', 'Wireless ergonomic mouse', 'LGT78542369', '2024-01-10', 3, 1, 'A01', 'X'),
       ('EQ005', 'HP Color LaserJet Pro', 'Network printer for office use', 'HPCL789456123', '2022-06-18', 4, 1, 'B02',
        'Y'),
       ('EQ006', 'Microsoft Surface Hub', 'Interactive whiteboard', 'MS-SH-85236974', '2023-10-05', 5, 4, 'A01', 'Z'),
       ('EQ007', 'Meta Quest 3', 'VR headset with touch controllers', 'MTQ3-785412', '2023-09-14', 7, 2, 'A01', 'Z'),
       ('EQ008', 'Sony 4K Projector', 'Conference room projector', 'SNY4K789654', '2022-09-30', 5, 1, 'A01', 'Y'),
       ('EQ009', 'Wacom Intuos Pro', 'Graphic design tablet', 'WCM98745632', '2023-07-12', 3, 3, 'C03', 'Y'),
       ('EQ010', 'HTC Vive Pro 2', 'High-end VR headset with base stations', 'HTC-VP2-852147', '2023-11-18', 7, 1,
        'A01', 'Z'),
       ('EQ011', 'MacBook Pro 16"', 'Apple Silicon M2 Max, 32GB RAM', 'MBPM2-2023-87654', '2023-06-10', 1, 1, 'A01',
        'Y'),
       ('EQ012', 'Lenovo ThinkPad X1 Carbon', 'Business ultrabook with i7', 'LNV-X1C-45678', '2023-04-22', 1, 2, 'A01',
        'Y'),
       ('EQ013', 'HP EliteBook 840 G8', 'Enterprise laptop with docking', 'HPE840-78542', '2022-12-05', 1, 1, 'B02',
        'Y'),
       ('EQ014', 'Microsoft Surface Laptop 5', 'Touchscreen ultraportable', 'MS-SL5-96325', '2023-11-30', 1, 4, 'A01',
        'Y'),
       ('EQ015', 'ASUS ROG Zephyrus G14', 'Gaming laptop with RTX 4070', 'ROG-Z14-74125', '2023-03-18', 1, 3, 'B02',
        'Z'),
       ('EQ016', 'Logitech MX Keys', 'Wireless premium keyboard', 'LGT-MXK-85214', '2023-09-14', 3, 1, 'A01', 'X'),
       ('EQ017', 'Apple Magic Keyboard', 'With numeric keypad', 'AMK-789-32654', '2022-08-17', 3, 2, 'A01', 'X'),
       ('EQ018', 'Keychron K3', 'Low profile mechanical keyboard', 'KCR-K3-78521', '2023-07-28', 3, 1, 'A01', 'X'),
       ('EQ019', 'Dell Ultrasharp U2720Q', '27" 4K monitor with USB-C', 'DU2720Q-85214', '2023-01-12', 1, 1, 'A01',
        'Y'),
       ('EQ020', 'LG 34WP65C', '34" Ultrawide curved monitor', 'LG34W-965412', '2023-08-05', 1, 2, 'B02', 'Y'),
       ('EQ021', 'Samsung Odyssey G7', '32" Gaming monitor 240Hz', 'SG7-32-85214', '2023-05-21', 1, 1, 'A01', 'Y'),
       ('EQ022', 'Intel NUC 13 Pro', 'Mini PC i7, 32GB RAM', 'INUC13-47856', '2023-10-19', 1, 1, 'A01', 'Y'),
       ('EQ023', 'Mac Mini M2', 'Compact desktop with 16GB RAM', 'MMM2-2023-14785', '2023-04-02', 1, 2, 'A01', 'Y'),
       ('EQ024', 'Corsair HS70 Pro', 'Wireless gaming headset', 'CHS70-12547', '2022-11-15', 3, 3, 'C03', 'X'),
       ('EQ025', 'Blue Yeti Microphone', 'USB condenser microphone', 'BY-USB-23541', '2023-02-08', 3, 1, 'B02', 'Y'),
       ('EQ026', 'WD Elements 5TB', 'External hard drive', 'WDE5TB-85214', '2023-06-30', 1, 1, 'A01', 'X'),
       ('EQ027', 'Samsung T7 Shield 2TB', 'Rugged portable SSD', 'ST7S-2TB-21456', '2023-03-25', 1, 2, 'A01', 'X'),
       ('EQ028', 'HP LaserJet M428fdw', 'Multifunction monochrome laser', 'HPLJ-M428-75395', '2022-09-11', 4, 1, 'B02',
        'Y'),
       ('EQ029', 'Epson EcoTank ET-2850', 'Inkjet printer with tank system', 'EPET-2850-78542', '2023-07-05', 4, 3,
        'B02', 'Y'),
       ('EQ030', 'Brother HL-L3270CDW', 'Color laser printer', 'BHL-3270-96385', '2023-01-28', 4, 1, 'A01', 'Y'),
       ('EQ031', 'Cisco Meraki MR46', 'WiFi 6 access point', 'CMMR46-96325', '2023-04-15', 6, 1, 'A01', 'Y'),
       ('EQ032', 'Ubiquiti UniFi U6-Pro', 'Enterprise WiFi 6 AP', 'UBU6-PRO-45632', '2023-08-18', 6, 4, 'A01', 'Y'),
       ('EQ033', 'TP-Link TL-SG3428X', '24-Port Gigabit Smart Switch', 'TPSG3428-96352', '2022-10-08', 6, 2, 'B02',
        'Y'),
       ('EQ034', 'Synology DS923+', '4-bay NAS with 16TB storage', 'SYNDS923-85214', '2023-11-12', 1, 1, 'A01', 'Z'),
       ('EQ035', 'QNAP TS-464', '4-bay NAS for business', 'QPTS464-52369', '2023-02-25', 1, 3, 'B02', 'Z'),
       ('EQ036', 'APC Smart-UPS 1500VA', 'Battery backup with AVR', 'APC1500-78965', '2022-12-18', 6, 1, 'A01', 'Y'),
       ('EQ037', 'CyberPower CP1500PFCLCD', 'PFC Sinewave UPS System', 'CP1500-45236', '2023-05-19', 6, 2, 'A01', 'Y'),
       ('EQ038', 'Raspberry Pi 4 B Kit', '8GB model with case and power', 'RPi4-8GB-78452', '2023-09-05', 1, 1, 'A01',
        'X'),
       ('EQ039', 'Arduino Mega 2560 Rev3', 'Microcontroller development board', 'ARDM-2560-96358', '2023-01-05', 1, 1,
        'A01', 'X'),
       ('EQ040', 'Logitech Brio 4K', 'Ultra HD webcam', 'LGT-BRIO-48521', '2023-07-15', 2, 2, 'A01', 'X'),
       ('EQ041', 'Jabra Speak 750', 'Conference speakerphone', 'JBR750-85214', '2022-11-24', 3, 1, 'B02', 'Y'),
       ('EQ042', 'Anker PowerConf S3', 'Bluetooth conference speaker', 'ANPS3-45871', '2023-03-14', 3, 1, 'A01', 'X'),
       ('EQ043', 'Elgato Stream Deck MK.2', 'Customizable LCD keypad', 'ELSD-MK2-45698', '2023-06-22', 3, 3, 'B02',
        'Y'),
       ('EQ044', 'Microsoft Azure Kinect', 'Depth and motion sensing camera', 'MS-AZK-85214', '2023-09-28', 2, 4, 'A01',
        'Z'),
       ('EQ045', 'AMD Ryzen Developer Kit', 'Dev system with Ryzen 9', 'AMD-RDK-96385', '2023-08-10', 1, 1, 'A01', 'Z'),
       ('EQ046', 'Nvidia Jetson AGX Orin', 'AI computing developer kit', 'NV-JAGX-78542', '2023-10-25', 1, 2, 'A01',
        'Z'),
       ('EQ047', 'Supermicro Server Node', '1U rack server with Xeon', 'SMSN-1U-45236', '2022-09-15', 1, 1, 'B02', 'Z'),
       ('EQ048', 'Dell PowerEdge R750', '2U rack server for VMware', 'DPR750-85214', '2023-04-28', 1, 3, 'B02', 'Z'),
       ('EQ049', 'HP Z2 Tower G9', 'Workstation with RTX A4000', 'HPZ2G9-96358', '2023-07-01', 1, 1, 'A01', 'Z'),
       ('EQ050', 'Lenovo ThinkStation P360', 'Compact workstation', 'LTS-P360-85214', '2023-05-08', 1, 2, 'A01', 'Z'),
       ('EQ051', 'Apple Vision Pro', 'Spatial computing headset', 'AVP-24-123456', '2024-02-02', 7, 4, 'A01', 'Z');
