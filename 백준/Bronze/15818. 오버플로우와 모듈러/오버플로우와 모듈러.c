
#include <stdio.h>

int main()
{
    int cnt;
    long long u;
    long long v;
    
    int res=1;
    
    
    scanf("%d", &cnt);
    scanf("%lld", &v);
    for(int i=0;i<cnt;i++){
        scanf("%lld", &u);
        res=((u%v)*res)%v;
    }
    printf("%d", res);
    return 0;
}
