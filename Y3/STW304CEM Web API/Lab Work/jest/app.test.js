const app = require('./app');

//console.log(app.hello());

describe('Test Case: hello', ()=>{
	it('test case: should return hello', ()=>
		expect(app.hello()).toEqual("Hello");	
});

describe('Test Case: add', ()=>{
	it ('should add two numbers', ()=>{
		expect(app.add(2,'2')).toBe(4);
	});
	it('should not add strings', ()=>{
		expect(app.add(2,'2')).toBe('');
	});
	it('should not add objects', ()=>{
		expect(app.add(2,{})).toBe(null);
	});
	it('should not add arrays', ()=>{
		expect(app.add(2, [])).toBe(null);
	});
})

describe('Test Case: multiply', ()=>){
	it('should multiply two numbers', ()=>{
		expect(app.multiple(4,-5)).toBe(-20);
		expect(app.multiply(4,0)).toBe(0);
	});

describe('removeANames', ()=>{
	let names = ['Apple', 'Banana', 'Orange', 'Ashok'];
	it('should contain names without A', ()=>{
		expect(app.removeANames(names)).toContain('Banana');
		expect(app.removeANames(names)).toContain('Orange');
		expect(app.removeANames(names)).not.toContain('Apple');
		expect(app.removeANames(names)).not.toContain('Ashok');
		
	})
})
