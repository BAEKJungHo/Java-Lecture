package oepnchallenge;

public class MySortImpl implements MySort {
	
	private String[] sort = null; // 옮겨 담을 배열
	private String temp; // 임시 저장소
	
	public String[] sort(String[] strArray) {
		// 배열 크기 설정
		sort = new String[strArray.length]; 
		
		// 배열 복사
		for(int i=0; i<strArray.length; i++) { 
			sort[i] = strArray[i];
		}
		
		// 오름차순 정렬
        for (int i=0; i<sort.length-1; i++) {
            for (int k=0; k<sort.length-i-1; k++) {
                if ((sort[k].compareTo(sort[k+1])) > 0) {
                    temp = this.sort[k]; 
                    sort[k] = sort[k+1];
                    sort[k+1] = temp;
                }
            }
        }   
        return this.sort;
    
	}
	
	public String[] sort(String[] strArray, boolean descOrder) {
		// 배열 크기 설정 
		sort = new String[strArray.length];
		
		// 배열 복사
		for(int i=0; i<strArray.length; i++) {
			sort[i] = strArray[i];
		}
		
		// 내림차순 정렬
		if(descOrder) {
	        for (int i=0; i<sort.length-1; i++) {
	            for (int k=0; k<sort.length-i-1; k++) {
	                if ((sort[k].compareTo(sort[k+1])) < 0) {
	                    temp = this.sort[k]; 
	                    sort[k] = sort[k+1];
	                    sort[k+1] = temp;
	                }
	            }
	        }   
	        return this.sort;
	    // 오름차순 정렬
		} else if(!descOrder) {
	        for (int i=0; i<strArray.length-1; i++) {
	            for (int k=0; k<strArray.length-i-1; k++) {
	                if ((strArray[k].compareTo(strArray[k+1])) > 0) {
	                    strArray[k] = this.sort[i];
	                    strArray[k] = strArray[k+1];
	                    this.sort[i] = strArray[k+1]; 
	                }
	            }
	        }   
	        return this.sort;
		}
		return null;
	}
}
