class Helloworld {
    public static void main(String args[]) {
        if(args.length==3){
            System.out.println("please enter the values");
            System.out.println("first name:"+args[0]);
            System.out.println("second name:"+args[1]);
            try{
                int age = Integer.parseInt(args[2]);
                System.out.println("age:"+age);
            }
            catch(Exception e){
                System.out.println("please enter valid age");
            }
        }
        else{
            System.out.println("please enter three command line arguments");
        }



    }
}