def template = """<div class="desc">
            <button type="roll" class="sheet-text-button"
                    value="&{template:default} {{name=Athletics}} {{DN=?{Target DN? |2|3|4|5|6}}} {{Result=[[(@{athletics_attribute}+@{athletics_1}+@{athletics_2}+@{athletics_3}+@{athletics_perm_bonus}+?{Athletics bonus|0})d6s>?{Target DN? |2|3|4|5|6}]] successes}} {{focus=[[@{athletics_focus_1} + @{athletics_focus_2} + @{athletics_focus_3}]] focus points}}"
                    name="roll_athletics">Athletics</button>
            <select class="attribute-select" name="attr_athletics_attribute">
                <option value="@{body}">body</option>
                <option value="@{mind}">mind</option>
                <option value="@{soul}">soul</option>
            </select>
        </div>
        <div class="training">
            <input type="checkbox" name="attr_athletics_1" value="1">
            <input type="checkbox" name="attr_athletics_2" value="1">
            <input type="checkbox" name="attr_athletics_3" value="1">
        </div>
        <div class="focus">
            <input type="checkbox" name="attr_athletics_focus_1" value="1">
            <input type="checkbox" name="attr_athletics_focus_2" value="1">
            <input type="checkbox" name="attr_athletics_focus_3" value="1">
        </div>
        """

def skillsList = ["Arcana",
                  "Athletics",
                  "Awareness",
                  "Ballistic Skill",
                  "Beast Handling",
                  "Channelling",
                  "Crafting",
                  "Determination",
                  "Devotion",
                  "Dexterity",
                  "Entertain",
                  "Fortitude",
                  "Guile",
                  "Intimidation",
                  "Intuition",
                  "Lore",
                  "Medicine",
                  "Might",
                  "Nature",
                  "Reflexes",
                  "Stealth",
                  "Survival",
                  "Theology",
                  "Weapon Skill"]

def attributesList = ["soul",
                      "body",
                      "mind",
                      "body",
                      "soul",
                      "mind",
                      "mind",
                      "soul",
                      "soul",
                      "body",
                      "soul",
                      "body",
                      "mind",
                      "soul",
                      "mind",
                      "mind",
                      "mind",
                      "body",
                      "mind",
                      "body",
                      "body",
                      "mind",
                      "mind",
                      "body"]

skillsList.eachWithIndex { it, index ->
    def temp = template
            .replace("athletics", it.toLowerCase().replace(" ", "_"))
            .replace("Athletics", it)
            .replace("<option value=\"@{" + attributesList.get(index) + "}\">" + attributesList.get(index) + "</option>",
                    "<option value=\"@{" + attributesList.get(index) + "}\" selected=\"selected\">" + attributesList.get(index) + "</option>")
    println(temp)
    if (it == "Fortitude") {
        println("""        </div>
        <div class="skills">
            <div></div>
            <div>Training</div>
            <div>Focus</div>
            """)
    }
}