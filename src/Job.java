/**
 * The job class implements the comparable with type Job
 * Class will have two variables that will have to do the task for the job and when there is a due date
 * @author jasonvu
 */
public class Job implements Comparable<Job>
{
	/** private variable task that is what the user needs to do**/
	private String task;
	
	/** private variable integer month for date**/
	private int month;
	
	/** private variable integer day for date**/
	private int day;
	
	/** private variable integer year for date**/
	private int year;
	
	/** private variable integer hour for time**/
	private int hour;
	
	/**private variable integer minute for time**/
	private int minute;
	
	/**
	 * job constructor class that creates the task and the due date for the task
	 * @param t - task the user has to do
	 * @param d - due date that the task is due
	 */
	public Job(String t, int m, int d, int y, int h, int min)
	{
		task = t;
		month = m;
		day = d;
		year = y;
		hour = h;
		minute = min;
	}
	
	/**
	 * Getter that returns the task of the user
	 * @return task - the task of the user
	 */
	public String getTask()
	{
		return task;
	}
	
	/**
	 * @returns the task and date combined together
	 * @Overrides the toString method
	 */
	@Override
	public String toString()
	{
		if(hour<10 && minute >10)
		{
			return task + " " + month +"/" +day+"/"+year +" "+"0"+hour+":"+minute;
		}
		
		else if(minute<10 && hour > 10)
		{
			return task + " " + month +"/" +day+"/"+year +" " +hour+":"+"0"+minute;
		}
		
		else if(minute < 10 && hour < 10)
		{
			return task + " " + month +"/" +day+"/"+year +" "+"0"+hour+":"+"0"+minute;
		}
		else
		{
			return task + " " + month +"/" +day+"/"+year +" " +hour+":"+minute;
		}
	}
	
	/**
	 * 
	 * function compares the dates and tasks in order to order them correctly from date first and then task
	 * if years are equal to each other return month-o.month, if months are equal to each other return day-o.day
	 * if hour are equal to each other return minute-o.minute
	 * if minute are equal to each other return task.compareTo(o.task)
	 * else return year-o.year
	 * 
	 * @return this.task.compareTo(o.task) - returns a negative, positive or 0 
	 * @return this.minute-o.minute - returns a negative, positive or 0
	 * @return this.hour-o.hour - returns a negative, positive or 0
	 * @return this.day-o.day - returns a negative, positive or 0
	 * @return this.month-o.month - returns a negative, positive or 0
	 * @return this.year-o.year - returns a negative, positive or 0
	 */
	@Override
	public int compareTo(Job o) {
		if(this.year-o.year == 0)
		{
			if(this.month-o.month == 0)
			{
				if(this.day-o.day == 0)
				{
					if(this.hour - o.hour == 0)
					{
						if(this.minute-o.minute == 0)
						{
							return this.task.compareTo(o.task);
						}
						
						else
						{
							return this.minute-o.minute;
						}
					}
					
					else
					{
						return this.hour-o.hour;
					}
				}
				
				else
				{
					return this.day-o.day;
				}
			}
			
			else
			{
				return this.month-o.month;
			}
		}

		return (this.year-o.year);
	}

}
