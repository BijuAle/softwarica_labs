const app = {
  hello: function() {
    return "Hello";
  },
  add: function(x, y) {
    if (typeof x !== "number" || typeof (y !== "nummber")) {
      return null;
    }
    return x + y;
  },
  multiply: (x, y) => x * y
};

module.export = app;
