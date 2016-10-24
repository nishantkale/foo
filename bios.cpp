
#include <iostream>
#include <stdlib.h>
#include <sys/stat.h>

using namespace std;

int main()
{
    cout<<"\n\nHARDWARE BOOTED FROM...\n\n";
    system("[ -d /sys/firmware/efi ] && echo UEFI || echo BIOS"); //Check whether the dir /sys/firmware/efi exists, if it exists it means the kernel has booted in EFI mode.
    return 0;
}
