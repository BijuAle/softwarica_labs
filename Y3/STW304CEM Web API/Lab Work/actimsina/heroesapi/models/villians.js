const mongoose = require('mongoose');
const Schema = mongoose.Schema;

var villiansSchema = new Schema({
    name: {
        type: String,
        required: true
    },
    desc: {
        type: String,
        required: true
    },
},
    {
        timestamps: true
    });

var Villians = mongoose.model('Villian', villiansSchema);
module.exports = Villians;    