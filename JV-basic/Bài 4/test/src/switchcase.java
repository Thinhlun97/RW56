import java.sql.SQLOutput;

public class switchcase {
    public static void main(String[] args) {
        //ví dụ 1
//        int x = 3;
//
//        switch (x){
//            case 1:
//            System.out.println("một");
//            break;
//            case 2:
//                System.out.println("hai");
//                break;
//            case 3:
//                System.out.println("ba");
//                break;
//            case 4:
//                System.out.println("bốn");
//                break;
//            case 5:
//                System.out.println("năm");
//                break;
//            default:
//                System.out.println("Nhập số từ 1-5");
//                break;
//        }
        //Ví dụ 2
        String thoiTiet = "abv";

        switch (thoiTiet){
            case "mưa":
            System.out.println("đi làm bằng taxi");
            break;
            case "nắng":
            System.out.println("đi làm bằng xe máy");
            break;
            case "Bão":
            System.out.println("xin nghỉ");
            break;
            default:
            System.out.println("đi bằng chân");
            break;

                }
    }
}
