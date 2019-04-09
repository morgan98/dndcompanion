
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "characters")
class characters {

    @PrimaryKey(autoGenerate = true)
    var cid: Int = 0

    @ColumnInfo(name = "character_name")
    var charcter_name: String? = null

    @ColumnInfo(name = "pronouns")
    var pronouns: String? = null

    @ColumnInfo(name = "race")
    var race: String? = null

    @ColumnInfo(name + "charcter_class")
    var character_class: String? = null

    @ColumnInfo(name + "strength")
    var strength: Int = 0

    @ColumnInfo(name + "dexterity")
    var dexterity: Int = 0

    @ColumnInfo(name + "constitution")
    var constitution: Int = 0

    @ColumnInfo(name + "intelligence")
    var intelligence: Int = 0

    @ColumnInfo(name + "wisdom")
    var wisdom: Int = 0

    @ColumnInfo(name + "charisma")
    var charisma: Int = 0
}