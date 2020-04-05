package be.pvgroup.tpetool.model.proposal;

public class ProposalInput {

	private ProposalData data;
	private String requesterUsername;

	public ProposalData getData() {
		return data;
	}

	public void setData(ProposalData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ProposalInput{" + "data=" + data + '}';
	}

	public static final class ProposalInputBuilder {
		private ProposalData data;

		private ProposalInputBuilder() {
		}

		public static ProposalInputBuilder aProposalInput() {
			return new ProposalInputBuilder();
		}

		public ProposalInputBuilder withData(ProposalData data) {
			this.data = data;
			return this;
		}

		public ProposalInput build() {
			ProposalInput proposalInput = new ProposalInput();
			proposalInput.setData(data);
			return proposalInput;
		}
	}

	public String getRequesterUsername() {
		return requesterUsername;
	}

	public void setRequesterUsername(String requesterUsername) {
		this.requesterUsername = requesterUsername;
	}
}
