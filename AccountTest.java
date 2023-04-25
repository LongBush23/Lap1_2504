import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
		AccountList accountList = new AccountList();
		Scanner scanner = new Scanner(System.in);
		int choise;
		
		do {
			System.out.println("---------MENU---------");
			System.out.println("1. Them tai Khoan");
			System.out.println("2. So Tk hien co");
			System.out.println("3. in ra tat ca thong tin tai khoan");
			System.out.println("4. Nap tien vao tai khoan");
			System.out.println("5. Rut tien");
			System.out.println("6. chuyen tien");
			System.out.println("0 Thoat");
			System.out.println("vui long chon chuc nang ");
			choise = scanner.nextInt();
			
			switch(choise) {
				case 1:
					System.out.print("Nhập số TK: ");
                    int soTK = scanner.nextInt();
                    System.out.print("Nhập tên TK: ");
                    String tenTK = scanner.next();
                    scanner.nextLine();
                    System.out.print("Nhập số dư: ");
                    double soTien = scanner.nextDouble();
                    Account account = new Account(soTien, soTK, tenTK);
                    boolean result = accountList.addAccount(account);
                    if (result) {
                        System.out.println("Thêm tài khoản thành công!");
                    } else {
                        System.out.println("Thêm tài khoản thất bại. Danh sách đã đầy!");
                    }
                    break;
				case 2: 
					int soTKHienCo = accountList.getAccountCount();
                    System.out.println("Số tài khoản hiện có: " + soTKHienCo);
					break;
				case 3:
					accountList.printAllAccounts();
					break;
				case 4:
					System.out.print("Nhập số TK: ");
                    int soTKNapTien = scanner.nextInt();
                    System.out.print("Nhập số tiền cần nạp: ");
                    double soTienNap = scanner.nextDouble();
                    Account accountNapTien = accountList.findAccount(soTKNapTien);
                    if (accountNapTien != null) {
                        accountNapTien.napTien(soTienNap);
                        System.out.println("Nạp tiền thành công!");
                    } else {
                        System.out.println("Không tìm thấy tài khoản với số TK đã nhập!");
                    }
					break;
				case 5:
					System.out.print("Nhập số TK: ");
				    int soTKRut = scanner.nextInt();
				    System.out.print("Nhập số tiền cần rút: ");
				    double soTienRut = scanner.nextDouble();
				    Account accountRut = accountList.findAccount(soTKRut);
				    if (accountRut != null) {
				        accountRut.rutTien(soTienRut);
				    } else {
				        System.out.println("Không tìm thấy tài khoản với số TK đã nhập!");
				    }
					break;
				case 6:
				    System.out.print("Nhập số TK nguồn: ");
				    int soTKNguon = scanner.nextInt();
				    System.out.print("Nhập số TK đích: ");
				    int soTKDich = scanner.nextInt();
				    System.out.print("Nhập số tiền cần chuyển: ");
				    double soTienChuyen = scanner.nextDouble();
				    Account accountNguon = accountList.findAccount(soTKNguon);
				    Account accountDich = accountList.findAccount(soTKDich);
				    if (accountNguon != null && accountDich != null) {
				        accountNguon.chuyenKhoan(accountDich, soTienChuyen);
				    } else {
				        System.out.println("Không tìm thấy tài khoản với số TK đã nhập!");
				    }
				    break;
			}
		} while (choise != 0);
	}
}
