package ReadFileToArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaBi on 18.04.2016.
 * class Room & public class ReadObjectsFromFile
 */

class Room {
        String number;
        private int seats;
        private double square;
        private boolean wifi;

    public Room() {
    }

    public Room(String number, int seats, double square, boolean wifi) {
        this.number = number;
        this.seats = seats;
        this.square = square;
        this.wifi = wifi;
    }

    public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public int getSeats() {
            return seats;
        }

        public void setSeats(int seats) {
            this.seats = seats;
        }

        public double getSquare() {
            return square;
        }

        public void setSquare(double square) {
            this.square = square;
        }

        public boolean isWifi() {
            return wifi;
        }

        public void setWifi(boolean wifi) {
            this.wifi = wifi;
        }

        @Override
        public String toString() {
            return "Room: " +
                   "\nnumber: '" + number + '\'' +
                   ";\nseats: " + seats +
                   ";\nsquare: " + square +
                   ";\nwifi: " + wifi + ";\n";
        }
}

public class ReadObjectsFromFile {
    /**
     * class ReadObjectsFromFile contains methods,
     * that read objects from the file, parse and print data about rooms
     */

    /*
     * File room.txt contains next data:
     * 1 кімната, 5, 20.0, true
     * 2, 15, 30.0, true
     * Stanford, 20, 40.0, false
     * 6, 3, 2.0, true
     */
    public static final String TEXT_FILE_NAME = "room.txt";  // name of the file with data
    public static final String CORRECT_DATA_FROM_FILE = "Correct data from file: \n";
    public static final String REG_EXP = "[,][\\s]+";   // regular expression to check data
    private static String currentFileString;
    private static BufferedReader inputFile;
    private static List<Room> roomsDataList;

    // this method prints String message
    public static void printMessage(String mes){
        System.out.println(mes);
    }

    // this method prints objects Room
    private static void printMessage(Room currentRoom) {
        System.out.println(currentRoom);
    }

    // this method reads and parses objects from the file, return roomsDataList
    public static List readObjectsFromFile() throws IOException {
        roomsDataList = new ArrayList<Room>();
        inputFile = new BufferedReader(new FileReader(TEXT_FILE_NAME));

        while ((currentFileString = inputFile.readLine()) != null) {
            String stringData[] = currentFileString.split(REG_EXP);

            Room newRoom = new Room();
            newRoom.setNumber(stringData[0]);

            try {
                newRoom.setSeats(Integer.parseInt(stringData[1]));
                newRoom.setSquare(Double.valueOf(stringData[2]));
                newRoom.setWifi(Boolean.parseBoolean(stringData[3]));
            } catch (Exception e) {
                e.getMessage();
            }
            roomsDataList.add(newRoom);
        }
        inputFile.close();
        return roomsDataList;
    }

    // this method calls method readObjectsFromFile to read and parse objects from the file,
    // and prints roomsDataList
    public static void printRoomsDataList() throws IOException {
        printMessage(CORRECT_DATA_FROM_FILE);
        readObjectsFromFile();
        roomsDataList.forEach(ReadObjectsFromFile::printMessage);
    }

    // the method main launches the program by calling the method printRoomsDataList
    public static void main(String args[]) {
        try {
            printRoomsDataList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
