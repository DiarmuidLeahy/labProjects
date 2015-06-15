#include <iostream>
using namespace std;

int isPrime(int num);
//check to see how many primes there are between 0 and a given number n
//a list of all pimes is  also printed
int main()
{
    int n;
    int counter = 0;
    cout << "enter a number" << endl;
    cin >> n;

    for(int i=2;i<n;i++)
    {
        if(isPrime(i))
        {
            counter++;
            cout << i << endl;
        }
    }
    cout << "There are " << counter << " primes between 1 and " << n << endl;
}

int isPrime(int num)
{
    if(num==2){   //special case for n=2
        return 1;
    }
    if(num % 2 ==0){
        return 0;   //if it's even, no need to check further
    }
    for(int i = 3;i * i <= num; i+= 2)  //start at 3 and jump in steps of two to sheck all odd numbers
    {
        if(num % i ==0)
        {
            return 0;
        }
    }
    return 1;
}

