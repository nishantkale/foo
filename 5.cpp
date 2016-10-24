#include<iostream>
#include<unistd.h>
#include<string.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<sys/wait.h>

using namespace std;
int main()
{
char str[255]={0}; 
char res[255]={0}; 
int fd[2]; 
pipe(fd); 
pid_t pid; 
pid=fork(); 

if(pid==0)
{
close(fd[0]);     
cout<<"Enter the String:\t";
cin>>str;
write(fd[1],str,strlen(str)); 
}
 //parent process block
else if(pid>0)
{
waitpid(pid,0,0);      
close(fd[1]);           
int len=(read(fd[0],res,255));
len--;
cout<<"\nReverse String:\t";
for(int i=len;i>=0;i--)
{
cout<<res[i];
}
cout<<endl;
}
 //failure block
else
{
cout<<"could not fork\n";
}
return 0;
}
