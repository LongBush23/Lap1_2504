import java.util.ArrayList;

public class AccountList {
	 private Account[] accList;
	 private int count;
	 
	 //constructor mac nhien
	 public AccountList() {
		 accList = new Account[10];
		 count = 0;
	 }
	 //constructor co tham so n
	 public AccountList(int n) {
		 if (n > 0) {
	            accList = new Account[n];
	        } else {
	            accList = new Account[10];
	        }
	        count = 0;
	 }
	 public boolean addAccount(Account account) {
		 if(count < accList.length) {
			 accList[count] = account;
			 count ++;
			 return true;
		 } else {
			 return false;
		 }
	 }
	 public Account findAccount(int soTK) {
	        for (int i = 0; i < count; i++) {
	            if (accList[i].getSoTK()==(soTK)) {
	                return accList[i];
	            }
	        }
	        return null;
	 }	 
	 
	 public boolean deleteAccount(int soTK) {
	        for (int i = 0; i < count; i++) {
	            if (accList[i].getSoTK()==(soTK)) {
	                for (int j = i; j < count - 1; j++) {
	                    accList[j] = accList[j + 1];
	                }
	                accList[count - 1] = null;
	                count--;
	                return true;
	            }
	        }
	        return false;
	    }
	 // tinh so luong tai khoan
	 public int getAccountCount() {
	        return count;
	    }
	 public void printAllAccounts() {
		 System.out.println("Danh sách tài khoản:");
		 for (int i = 0; i < count; i++) {
			 System.out.println(accList[i].toString());
			 System.out.println("------------------------");
		 }
	}
	 
}
