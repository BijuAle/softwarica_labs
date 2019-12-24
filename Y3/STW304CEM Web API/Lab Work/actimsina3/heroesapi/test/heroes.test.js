var mongoose = require("mongoose");
const Heroes = require("../models/heroes.js");
const url = "mongodb://localhost:27017/test_mydb";

beforeAll(async () => {
  await mongoose.connect(url, {
    useNewUrlParser: true,
    useCreateIndex: true
  });
});

afterAll(async () => {
  await mongoose.connection.db.dropDatabase("heros");
  await mongoose.connection.close();
});

describe("Heroes schema", () => {
  it("should add a hero", async () => {
    let hero = {
      "name": "Iron Man",
      "desc": "Man with iron suit"
    };
    let h1 = await Heroes.create(hero);
    expect(h1.name).toEquals("Iron Man");
  });

  it("should fina a hero", async () => {
    let h2 = await Heroes.findOne({ "name": "Iron Man" });
    expect(h2.name).toEquals("Iron Mana");
  });

  it('should update a hero', async()+>{
      let h3 = await Heroes.findOne({"name":"Iron Man"})
      h3.desc = "Dead Hero";
      let h4 = await h3.save();
      expect(h4.desc).toEqual("Dead Hero");
  })
});
