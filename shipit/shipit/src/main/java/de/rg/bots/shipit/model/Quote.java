package de.rg.bots.shipit.model;

public class Quote {

	public static class Key {

		private String key;

		public Key(String key) {
			assert (key != null && !key.isEmpty());
			this.key = key;
		}

		@Override
		public String toString() {
			return key;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			return true;
		}
	}

	private Key key;
	private Transport transport;

	public Quote(Key key, Transport transport) {
		this.key = key;
		this.transport = transport;
	}

}
