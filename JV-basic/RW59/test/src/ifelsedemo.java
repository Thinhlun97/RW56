public class ifelsedemo {
    public static void main(String[] args){
        String thoiTiet = "bão";

        //Loại 1
//        if(thoiTiet == "mưa"){
//            System.out.println("Đi làm bằng xe máy");
//        }else{
//            System.out.println("Đi làm bằng taxi");
//        }
        //Loại 2
        if(thoiTiet == "mưa"){
            System.out.println("đi làm bằng taxi");
        }else if(thoiTiet == "bão"){
            System.out.println("nghỉ làm");
        }else{
            System.out.println("Đi làm bằng xe máy");
        }
    }
}
