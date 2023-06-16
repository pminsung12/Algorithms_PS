def solution(wallpaper):
    answer = []
    
    lux,luy,rdx,rdy=1e9,1e9,0,0
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j]=='#':
                lux=min(lux,i)
                luy=min(luy,j)
                rdx=max(rdx,i)
                rdy=max(rdy,j)
    
    answer=[lux,luy,rdx+1,rdy+1]
    return answer