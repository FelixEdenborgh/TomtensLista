

package tomtenslista;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;



public class TomtensLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connectToAndQueryDatabase("root", "Hinsaringen39");
        }
        catch(Exception p){
            p.printStackTrace();
            System.out.println("Some thing whent wrong!");
        }
        
        
    }


    public static void connectToAndQueryDatabase(String username, String password){
        int x = 0;
        String s = null;
        boolean b = true;
        try (Connection con = (Connection) DriverManager.getConnection(" jdbc:mysql://localhost:3306/tomtedatabasedemoiot?serverTimezone=UTC", username, password);){
            
            Statment stmt = (Statment) con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, nice FROM child");
            
             while(rs.next()){
            x = rs.getInt("id");
            s = rs.getString("name");
            b = rs.getBoolean("nice");
            for(int z = 0; z < 15; z++){
                System.out.print(x + " ");
                System.out.print(s + " ");
                System.out.print(x);
            }
        }
            
        }
        catch(Exception e){
             e.printStackTrace();
            System.out.println("Cant Connect SomeThing Whent Wrong");
        }
        
       
        
    }
   

    
    
}
