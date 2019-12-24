const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const heroSchema = new Schema({
    name: {
        type: String,
        required: true
    },
    desc: {
        type: String,
        required: true
    }
},
    {
        timestamps: true
    }
);

let Heroes = mongoose.model('Heroe', heroSchema);
module.exports = Heroes;