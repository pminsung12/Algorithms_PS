#include <stdio.h>

int main(){
	
	int a,b,c;
	scanf("%d %d %d",&a, &b, &c);
	int arr[9] = {0,};
	
	int n=a*b*c;
	
	int num;
	while(n>0){
		num = n%10;
		arr[num]++;
		n/=10;	
		
		
	}
	for(int i =0;i<10;i++){
		printf("%d\n",arr[i]);	
	}		
	
	return 0;
}