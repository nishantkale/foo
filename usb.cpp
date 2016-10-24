 #include <iostream>
#include <stdlib.h>
#include <sys/stat.h>
using namespace std;
int main()
{
    char Ans;
    int N;
re:    cout<<"\n\nPlease Insert The Pendrive Now...";
    cout<<"\n\nHave You Inserted The Pendrive ? [Y/N]";
    cin>>Ans;
    if(Ans=='y' || Ans=='Y')
    {
        system("sudo lsusb");       
        cout<<"\n\nIs The Pendrive Visible ? [Y/N]";
        cin>>Ans;       
        if(Ans=='y' || Ans=='Y')
        {
            cout<<"\n\nEntering Root Mode...\n\n";       
            cout<<"\n\nCopying System Files...\n\n";       
            system("sudo dd if=/home/gescoe/Documents/ubuntu.iso of=/dev/sdb && sync");
        }
        else
        {
            cout<<"\n\nPlease re-attach the pendrive and try again...\n\n";
            goto re;
        }
        cout<<"\n\nAll Done! Ready To Boot...\n\n";               
    }   
    else
    {
        goto re;   
    }
return 0;
}