class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int answer=0;
        int x = points[0][0];
        int y = points[0][1];
        
        for(int[] point : points){
            if(x==point[0] && y==point[1]){
                continue;
            }

            int xDist = Math.abs(point[0]-x);
            int yDist = Math.abs(point[1]-y);
            answer += (xDist + yDist - Math.min(xDist,yDist));

            x=point[0];
            y=point[1];
        }

        return answer;
    }
}