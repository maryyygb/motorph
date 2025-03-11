
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;

//import javax.swing.JOptionPane;
//How to get the total hours worked
//import java.time.LocalTime;
//import java.time.Duration;
import java.util.Scanner;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.text.ParseException;

public class TestCodes {

    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    private static final List<String> SCOPES
            = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
            throws IOException {
        // Load client secrets.
        InputStream in = SheetsQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets
                = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

//Employee Details
        final String spreadsheetId = "1MkD_V3c_TEE81CEoJMH_VPXAYpMckWfBuqbW42med5w";

//Employee Details
        final String range = "Employee Details!A2:S";
        Sheets service
                = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                        .setApplicationName(APPLICATION_NAME)
                        .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();

        Scanner scan = new Scanner(System.in);

        System.out.print("Type an employee ID: ");
        int empId = scan.nextInt(); //10003
        int rowLen = 14;
        int colLen = 33;

        ///  STORING EMPLOYEE ID TO AN ARRAYLIST
    ArrayList<Integer> empID = new ArrayList<Integer>();
        for (int i = 0; i <= 33; i++) {
            empID.add(Integer.parseInt(values.get(i).get(0).toString()));
        };

//        EMP LAST NAME
        ArrayList<String> emp_lname = new ArrayList<String>();
        for (int i = 0; i <= 33; i++) {
            emp_lname.add(values.get(i).get(1).toString());
        };

//        EMP FIRST NAME
        ArrayList<String> emp_fname = new ArrayList<String>();
        for (int i = 0; i <= 33; i++) {
            emp_fname.add(values.get(i).get(2).toString());
        };

//        EMP BIRTH DATE
        ArrayList<String> emp_birthD = new ArrayList<String>();
        for (int i = 0; i <= 33; i++) {
            emp_birthD.add(values.get(i).get(3).toString());
        };

//        EMP ADDRESS
        ArrayList<String> emp_adrs = new ArrayList<String>();
        for (int i = 0; i <= 33; i++) {
            emp_adrs.add(values.get(i).get(4).toString());
        };

//        EMP PHONE NUMBER
        ArrayList<String> emp_pNumber = new ArrayList<String>();
        for (int i = 0; i <= 33; i++) {
            emp_pNumber.add(values.get(i).get(5).toString());
        };

//        EMP SSS DEDUCTION
        ArrayList<String> emp_sss = new ArrayList<String>();
        for (int i = 0; i <= 33; i++) {
            emp_sss.add(values.get(i).get(6).toString());
        };

//        EMP PHILHEALTH DEDUCTION
        ArrayList<String> philH = new ArrayList<String>();
        for (int i = 0; i <= 33; i++) {
            philH.add(values.get(i).get(7).toString());
        };

//        EMP TIN DEDUCTION
        ArrayList<String> emp_tin = new ArrayList<String>();
        for (int i = 0; i <= 33; i++) {
            emp_tin.add(values.get(i).get(8).toString());
        };

//        EMP PAG-IBIG DEDUCTION
        ArrayList<String> pagIbig = new ArrayList<String>();
        for (int i = 0; i <= 33; i++) {
            pagIbig.add(values.get(i).get(9).toString());
        };

//        EMP STATUS
        ArrayList<String> emp_status = new ArrayList<String>();
        for (int i = 0; i <= 33; i++) {
            emp_status.add(values.get(i).get(10).toString());
        };

//        EMP POSITION
        ArrayList<String> emp_position = new ArrayList<String>();
        for (int i = 0; i <= 33; i++) {
            emp_position.add(values.get(i).get(11).toString());
        };

//        EMP BASIC SALARY
        ArrayList<String> basicSalary = new ArrayList<String>();
        for (int i = 0; i <= 33; i++) {
            basicSalary.add(values.get(i).get(13).toString());
        };

//        EMLP HOURLY RATE
        ArrayList<String> hourlyRate = new ArrayList<String>();
        for (int i = 0; i <= 33; i++) {
            hourlyRate.add(values.get(i).get(18).toString());
        };

        for (int i = 0; i < 33; i++) {
            
            if (empId == empID.get(i)) {

                if (true) {
                    print("PAYROLL RECEIPT: ");
                    print("");
                    print("--------------------");
                    print("");
                    print("Employee ID: " + empID.get(i));
                    print("Employee Name: " + emp_lname.get(i) + ", " + emp_fname.get(i));
                    print("");
                    print("*********************");
                    print("");
                    print("Employee Birthdate: " + emp_birthD.get(i));
                    print("Employee's Position: " + emp_position.get(i));
                    print("Employee's Status: " + emp_status.get(i));
                    print("");
                    print("*********************");
                    print("");
                    print("Employee' Basic Salary: " + basicSalary.get(i));
                    print("Employee's Hourly Rate: " + hourlyRate.get(i));
                    print("");
                    print("--------------------");
                    print("");
                    break;
                }

            } else if (empId > empID.get(33)) {
                print("Invalid Input!");
                print("Type from 10001-10034 only!");
                break;
            }
        }
        
        n(empId);
    }

//    ATTENDANCE RECORD
    public static void n(int id) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        //Employee Details
        final String spreadsheetId = "1MkD_V3c_TEE81CEoJMH_VPXAYpMckWfBuqbW42med5w";

        //Employee Details
        final String range = "Attendance Record!A2:G";
        Sheets service
                = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                        .setApplicationName(APPLICATION_NAME)
                        .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        
//      START OF CODE HERE

        Scanner scan = new Scanner(System.in);
        
        ArrayList<Integer> empID = new ArrayList<Integer>();
        for (int i = 0; i <= 681; i++) {
            empID.add(Integer.parseInt(values.get(i).get(0).toString()));
        };
        
        ArrayList<String> listData = new ArrayList<String>();
        
        ArrayList<Integer> idsE = new ArrayList<Integer>();
        ArrayList<String> nameE = new ArrayList<String>();
        ArrayList<String> logIn = new ArrayList<String>() ;
        ArrayList<String> date = new ArrayList<String>() ;
        ArrayList<String> logOut = new ArrayList<String>() ;
        ArrayList<String> totalHrsWorked = new ArrayList<String>() ;
        
        ArrayList<ArrayList<String>> allData = new ArrayList<ArrayList<String>>();
        
        for(int i = 0; i<618; i++) {
            
             int ids = Integer.parseInt(values.get(i).get(0).toString());
             if(id == ids) {
                 
                 int ref = i;
                 for(int j = 0; j<=6; j++) {
                 listData.add(values.get(ref).get(j).toString());
                 }
                 
             }
            
        }
        print(listData);
    }
    
    //   FOR PRINT SHORT
    static void print(Object any) {
        System.out.println(any);
    }

}
