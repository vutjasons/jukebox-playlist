/**
 * Song tester function that will ask the user if they would like to display list of songs,
 * display current song, add a new song to list,play next song or rerate song
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main1 {
	
	public static void main(String args[])
	{
		Heap<Song> h = new Heap<Song>();
		
		try
		{
			Scanner read = new Scanner(new File("playlist.txt"));
			
			do
			{
				String line = read.nextLine();
				Scanner sc = new Scanner(line);
				sc.useDelimiter(",");
				String tit = sc.next();
				String art = sc.next();
				String alb = sc.next();
				String r1 = sc.next();
				int rat = Integer.parseInt(r1);
				
				Song s1 = new Song(tit,art,alb,rat);
				
				h.addNode(s1);
				
			}while(read.hasNext());
			
			read.close();
		}catch(FileNotFoundException fnf)
		{
			System.out.println("File was not found");
		}
		
		boolean loop = true;
		
		while(loop)
		{
			int choice = menu();
			
			switch(choice)
			{
				case 1:
					
					if(h.isEmpty() == true)
					{
						System.out.println("The list is empty");
					}
					else
					{
						h.printHeap();
					}
					break;
				case 2:
					if(h.isEmpty() == true)
					{
						System.out.println("The list is empty");
					}
					
					else
					{
						System.out.println("Current song being played:");
						System.out.println(h.getNodeAt(0));
					}
					break;
					
				case 3:
					
					if(h.isEmpty() == true)
					{
						System.out.println("The list is empty");
					}
					
					else
					{
						System.out.println("Enter title of song: ");
						String input = CheckInput.getString();
						System.out.println("Enter artist of song: ");
						String input2 = CheckInput.getString();
						System.out.println("Enter album of song: ");
						String input3 = CheckInput.getString();
						System.out.println("Enter rating of song: ");
						int input4 = CheckInput.checkInt();
					
						Song newSo = new Song(input,input2,input3,input4);
					
						h.addNode(newSo);
					}
					break;
				case 4:
					
					if(h.isEmpty() == true)
					{
						System.out.println("The list is empty");
					}
					
					else
					{
						h.removeMin();
						
						if(h.isEmpty() == true)
						{
							System.out.println("The list is empty");
						}
						
						else
						{
							System.out.println("You are now playing: ");
							System.out.println(h.getNodeAt(0));
						}
					}
					break;
					
				case 5:
					
					if(h.isEmpty() == true)
					{
						System.out.println("The list is empty");
					}
					else
					{
						System.out.println("Enter new rating for current song: ");
						int input5 = CheckInput.checkInt();
						String title = h.getNodeAt(0).getTitle();
						String artist = h.getNodeAt(0).getArtist();
						String album = h.getNodeAt(0).getAlbum();
					
						Song rerate = new Song(title, artist, album, input5);
						h.removeMin();
						h.addNode(rerate);
					}
					break;
				case 6:
					
					System.out.println("Program has closed.");
					loop = false;
					break;
				
			}
		}
		
	}

	public static int menu()
	{
		System.out.println("What would you like to do?");
		System.out.println("1. Display the list of Songs");
		System.out.println("2. Display the current song");
		System.out.println("3. Add a new song to the list");
		System.out.println("4. Play next song");
		System.out.println("5. Re-rate current song");
		System.out.println("6. Quit");
		int menuChoice = CheckInput.checkIntRange(1,6);
		return menuChoice;
	}
}

