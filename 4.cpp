#include "iostream"
#include <sys/stat.h>
#include<time.h>
#include<errno.h>
using namespace std;
int main()
{
	char fi[30];  //variable to get file name
	char choice;  
	struct stat s;  // struct stat object

	do
	{
	cout<<endl<<"Enter File name"<<endl;
	cin>>fi;   //filename accepted 

	int c= stat(fi,&s); //catch return status of stat call

	if (c== 0 )   //if successful
	{
		cout<<endl<<"\t-:File details are :-\t"<<endl<<endl;
		cout<<"Device id :"<<s.st_dev<<endl;
		cout<<"inode :"<<s.st_ino<<endl;
		cout<<"Protection :"<<s.st_mode<<endl;
		cout<<"No. of hard links :"<<s.st_nlink<<endl;
		cout<<"User id :"<<s.st_uid<<endl;
		cout<<"Group id :"<<s.st_gid<<endl;
		cout<<"Special file devices :"<<s.st_rdev<<endl;
		cout<<"Total Size :"<<s.st_size<<endl;
		cout<<"Last seen :"<<ctime(&s.st_atime);
		cout<<"status seen :"<<ctime(&s.st_ctime);
		//ctime to display time in calender format 
		cout<<"Last Modification :"<<endl;
		cout<<ctime(&s.st_mtime);
	}
 	else   //if failure
	{
		cout<<"\nFile Doesn't exists";
	} 

	cout<<"\n\nDo you wish to continue ?(y/n)\t";
	cin>>choice;
	}while(choice == 'y' || choice == 'Y'); // loop ends here
	return 0;
} //main ends here
