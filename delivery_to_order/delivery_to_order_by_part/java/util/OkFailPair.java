package util;

public class OkFailPair {
	private int ok;
	private int fail;

	public OkFailPair addOk() {
		ok++;
		return this;
	}

	public OkFailPair addFail() {
		fail++;
		return this;
	}

	public OkFailPair add(boolean value) {
		if (value)
			addOk();
		else
			addFail();
		return this;
	}

	public double possibility() {
		return ok / (double) (ok + fail);
	}
}
