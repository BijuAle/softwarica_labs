const mongoose = require('mongoose');
const Schema = mongoose.Schema;


var heroesSchema = new Schema({
    name: {
        type: String,
        required: true
    },
    desc: {
        type: String,
        required: true
    },

}, {
        timestamps: true
    });


var Heroes = mongoose.model('Heroe', heroesSchema);
module.exports = Heroes;