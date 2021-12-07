package tranducvu;

public class Main {
		public static void main(String [] args) {
			nhanvien nv[] = new nhanvien[3];
			nv[0] = new nhanvien("Trần Đức Vũ", 2003, 3, 7);
;	        nv[1] = new nhanvien("Trịnh Cong Toan", 2003, 7, 19);
	        nv[2] = new nhanvien("Dương Đăng Quang ", 2003, 3, 12);
	        double max = Math.max(Math.max(nv[0].luong(),nv[1].luong()),nv[2].luong());
	        for (nhanvien n : nv)
	        {
	           n.inThongTin(3);
	        }
	        System.out.println("=============================");
	        System.out.println("Danh sách nhân viên có lương vượt khung");
	                for (int i=0;i<3;i++){
	                    if (nv[i].getthamnien() >= 20 || nv[i].getheso() > 8 ){
	                        nv[i].inThongTin(i);
	                    }
	                }            
	        System.out.println("=============================");
	                System.out.println("Nhân viên có lương cao nhất");
	                for (int i=0;i<3;i++){
	                    if (nv[i].luong() == max) nv[i].inThongTin(i);
	                }
		}
	}