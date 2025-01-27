public class Conn {
    public Conn(){
        try{
            //driver registered
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
