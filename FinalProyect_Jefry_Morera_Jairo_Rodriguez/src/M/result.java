
package M;


public class result {
    private int Id;
    private int voterId;
    private int candidateId;

    public result(int Id, int voterId, int candidateId) {
        this.Id = Id;
        this.voterId = voterId;
        this.candidateId = candidateId;
    }

    public result(int voterId, int candidateId) {
        this.voterId = voterId;
        this.candidateId = candidateId;
    }

    public result() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }
    
    
}
