import java.util.*;

class PrecAngle
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int hr,mnt;
        System.out.println("Enter the Hours: ");
        hr=sc.nextByte();
        System.out.println("Enter the Minutes: ");
        mnt = sc.nextByte();
        float hr_angle;
        hr_angle = hr*30;
        int mnt_angle;
        mnt_angle = mnt*6;
        float flux;
        flux = mnt*0.5f;
        hr_angle=hr_angle+flux;
        float final_angle;
       if(hr_angle>mnt_angle)
       {
            final_angle = hr_angle - mnt_angle;
       }
       else
       {
            final_angle = mnt_angle - hr_angle;
       }
       if(final_angle<=180)
       {
            System.out.println("The angle between hour and minute hand is: " + final_angle + " Degrees.");
       }
       else
       {
            final_angle=360-final_angle;
            System.out.println("The angle between hour and minute hand is: " + final_angle + " Degrees.");
       }
        sc.close();
    }
}