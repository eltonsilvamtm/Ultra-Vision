package enums;

public enum Plans {
	
	MusicLover ("Music Lover"),
	VideoLover ("Video Lover"),
	TVLover ("TV Lover"),
	Premium ("Premium");
	
	private String plan;

	Plans(String plan) {
		this.plan = plan;
	}
	
	public String GetPlan() {
		return this.plan;
	}
	
}
