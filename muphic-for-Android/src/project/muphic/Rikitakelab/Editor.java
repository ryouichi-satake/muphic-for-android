package project.muphic.Rikitakelab;

public interface Editor {
	//とじる
	public abstract void close();

	//選択１
	public abstract void firstSelect();

	//選択２
	public abstract void secondSelect();

	//選択３
	public abstract void thirdSelect();

	//けす
	public abstract void delete();

	//ぜんぶけす
	public abstract void deleteAll();
}
