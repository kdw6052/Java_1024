package day19;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
public interface BookManagerService {
	void printMenu();
	void runMenu(ArrayList<BookInfo> book,int menu);
	void addbook(ArrayList<BookInfo> book);
	void printBook(ArrayList<BookInfo> book,Predicate<BookInfo>p);
	void printSubMenu();
	void selectSubMenu(ArrayList<BookInfo> book,int subMenu);
}
