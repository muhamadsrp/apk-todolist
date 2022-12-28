public class rutinitasMuhari {
    public static String[] data = new String[5];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("RUTINITAS");
        viewShowRutinitas();
    }
    /**
     * Menampilakn Rutinitas
     */
    public static void showRutinitas() {
        for (int i = 0; i < data.length; i++) {
            var rutinitas = data[i];
            var no = i+1;

            if (data[i] != null){
                System.out.println(no + " : " + rutinitas);
            }
        }
    }
    /**
     *Menambah Rutinitas
     */
    public static void addRutinitas(String rutinitas){
        //Resize
        var isFull = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null){
                isFull = false;
                break;
            }
        }
        if (isFull) {
            var tempo = data;
            data = new String[data.length * 2];

            for (int i = 0; i < tempo.length; i++) {
                data[i] = tempo[i];
            }
        }
        //Tambahkan data pada array yang NULL
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null){
                data[i] = rutinitas;
                break;
            }
        }
    }
    /**
     * Menghapus Rutinitas
     */
    public static boolean removeRutinitas(int numb){
        if ((numb-1) >= data.length){
            return false;
        } else if (data[numb-1] == null) {
            return false;
        }else {
            for (int i = (numb-1); i < data.length; i++) {
                if (i == (data.length-1)){
                    data[i] = null;
                } else {
                    data[i] = data[i+1];
                }
            }
            return true;
        }
    }

    /**
     * Menambah Inputan
     */
    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    /**
     * Menampilakan apk Rutinitas
     */
    public static void viewShowRutinitas(){
        while (true){
            showRutinitas();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")){
                viewAddRutinitas();
            } else if (input.equals("2")) {
                viewRemoveRutinitas();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak ditemukan!");
            }
        }

    }
    /**
     * Menampilkan add Rutinitas
     */
    public static void viewAddRutinitas(){
        System.out.println("Tambakan Rutinitas!");

        var rutinitas = input("(x) Jika Batal!");

        if (rutinitas.equals("x")){
            //Batal
        } else {
            addRutinitas(rutinitas);
        }
    }
    /**
     * Menampilkan remove Rutinitas
     */
    public static void viewRemoveRutinitas(){
        System.out.println("Nomor yang dihapus");

        var numb = input("(x) Jika Batal!");

        if (numb.equals("x")){
            //Batal
        } else {
            boolean delete = removeRutinitas(Integer.valueOf(numb));
            if (!delete){
                System.out.println("Gagal menghapus!");
            }
        }
    }
}
