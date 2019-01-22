/**
 * Job tester where the user has a choice of:
 * displaying the list of tasks to do
 * displaying the current task
 * adding a new task to the list
 * marking a completed task
 * postponing a task to a later date
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main2 
{
	public static void main(String args[])
	{
		Heap<Job> j = new Heap<Job>();
		
		try
		{
			Scanner read = new Scanner(new File("tasklist.txt"));
			
			do
			{
				String line = read.nextLine();
				Scanner sc = new Scanner(line);
				sc.useDelimiter(",");
				String task = sc.next();
				String dtime = sc.next();
				String month = dtime.substring(0,2);
				int month1 = Integer.parseInt(month);
				String day = dtime.substring(3,5);
				int day1 = Integer.parseInt(day);
				String year = dtime.substring(6,10);
				int year1 = Integer.parseInt(year);
				
				String hour = dtime.substring(11,13);
				int hour1 = Integer.parseInt(hour);
				String minute = dtime.substring(14,16);
				int minute1 = Integer.parseInt(minute);
				
				Job s1 = new Job(task, month1, day1, year1, hour1, minute1);
				
				j.addNode(s1);
				
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
					if(j.isEmpty() == true)
					{
						System.out.println("Task list is empty.");
					}
					
					else
					{
						j.printHeap();
					}
					break;
				case 2:
					if(j.isEmpty() == true)
					{
						System.out.println("Task list is empty.");
					}
					else{
						System.out.println("Current Task: ");
						System.out.println(j.getNodeAt(0));
					}
					break;
				case 3:
					if(j.isEmpty() == true)
					{
						System.out.println("Task list is empty.");
					}
					else{
						System.out.println("Enter task: ");
						String t1 = CheckInput.getString();
						System.out.println("Enter Month: ");
						int t2 = CheckInput.checkIntRange(1, 12);
						System.out.println("Enter Day: ");
						int t3 = CheckInput.checkIntRange(1,31);
						System.out.println("Enter Year: ");
						int t4 = CheckInput.checkInt();
						System.out.println("Enter Hour: ");
						int t5 = CheckInput.checkIntRange(0,23);
						System.out.println("Enter Minutes: ");
						int t6 = CheckInput.checkIntRange(0,59);
						
						Job newJob = new Job(t1, t2, t3, t4, t5, t6);
					
						j.addNode(newJob);
					}
					break;
				case 4:
					if(j.isEmpty() == true)
					{
						System.out.println("Task list is empty.");
					}
					else{
						j.removeMin();
						
						if(j.isEmpty())
						{
							System.out.println("Task list is empty");
						}
						else
						{
							System.out.println("Task completed!");
							System.out.println("New Task:");
							System.out.println(j.getNodeAt(0));
						}
					}
					break;
				case 5:
					if(j.isEmpty() == true)
					{
						System.out.println("Task list is empty.");
					}
					
					else{
						System.out.println("Enter month: ");
						int newdTime = CheckInput.checkIntRange(1,12);
						System.out.println("Enter day: ");
						int newdTime2 = CheckInput.checkIntRange(1,31);
						System.out.println("Enter year: ");
						int newdTime3 = CheckInput.checkInt();
						
						System.out.println("Enter hours: ");
						int newTime = CheckInput.checkIntRange(0,23);
						System.out.println("Enter minutes: ");
						int newTime2 = CheckInput.checkIntRange(0,59);
						
						String task = j.getNodeAt(0).getTask();
					
						j.removeMin();
					
						Job upJob = new Job(task, newdTime,newdTime2,newdTime3,newTime,newTime2);
					
						j.addNode(upJob);
					}
					break;
				case 6:
					System.out.println("Task program closed.");
					
					loop = false;
					break;
				
			}
		}
		
	}
	
	public static int menu()
	{
		System.out.println("What would you like to do?");
		System.out.println("1. Display the list of tasks");
		System.out.println("2. Display the current task");
		System.out.println("3. Add a new task to the list");
		System.out.println("4. Mark complete");
		System.out.println("5. Postpone current task");
		System.out.println("6. Quit");
		int menuChoice = CheckInput.checkIntRange(1,6);
		return menuChoice;
	}
}
	


