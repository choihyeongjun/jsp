package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//폴더생성
		
		//createFile();//파일 생성
		//createDir();//폴더생성
	//	dirList();//폴더목록
		//fileDelete();
		//fileCopy(args[0],args[1]);
		
	}
	//파일복사
	public static void fileCopy(String src,String tar) {
		try {
			FileInputStream fis=new FileInputStream("d:/img/사자.jpg");
		//	FileInputStream fis=new FileInputStream(src);
			FileOutputStream fos=new FileOutputStream("d:/img/사자1.jpg");
		//	FileOutputStream fos=new FileOutputStream(tar);
			
			byte[] readBytes=new byte[100];
			int readCnt=0;
			while((readCnt=fis.read(readBytes))!=-1) {//-1이란값이 더이상 들어오는값이 없는걸의미
				fos.write(readBytes,0,readCnt); //0부터 readCnt까지읽기
				
			}
			fis.close();
			fos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//파일삭제
	public static void fileDelete() {
		File file=new File("d:/img/data.txt");
		file.delete();//파일은 그냥 지울수있지만 폴더는 빈폴더일때 지울수있음 파일 폴더 둘다 이렇게지움
	}
	
	//폴더목록
	public static void dirList() {
		File dir=new File("d:/img");
		File[] list=dir.listFiles();//리턴값 파일 배열s라서
		for(File file:list) {
			System.out.println("이름: "+file.getName());
			System.out.println("크기: "+file.getTotalSpace()+" "+file.length());
		}
		
	}
	
	//파일생성
	public static void createFile() {
		File file=new File("d:/img/data.txt");//경로에파일생성
		try {
			file.createNewFile();//파일생성함수
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//폴더생성
	public static void createDir() {
		File dir=new File("d:/img");//경로밑에 폴더생성
		dir.mkdir();//폴더하나 만들기 폴더안에 폴더 만들려면 s붙여야됨
	}

}
