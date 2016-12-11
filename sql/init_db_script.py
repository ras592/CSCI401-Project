import os

"""
create_products
init_categories
init_products
"""

user = raw_input('Enter your database user: ')
password = raw_input('Enter your database password: ')

import_base_str = "mysql -u {} -p{} FastrSale < ".format(user, password)
run_base_str = "mysql -u {} -p{} FastrSale ".format(user, password)
init_stored_procs = [
    os.path.join('.', 'stored_proc', 'create_roles.sql'),
    os.path.join('.', 'stored_proc', 'create_categories.sql'),
    os.path.join('.', 'stored_proc', 'create_users.sql'),
    os.path.join('.', 'stored_proc', 'create_stores.sql'),
    os.path.join('.', 'stored_proc', 'create_products.sql'),
    os.path.join('.', 'stored_proc', 'init_roles.sql'),
    os.path.join('.', 'stored_proc', 'init_categories.sql'),
    os.path.join('.', 'stored_proc', 'init_users.sql'),
    os.path.join('.', 'stored_proc', 'init_stores.sql'),
    os.path.join('.', 'stored_proc', 'init_products.sql')
]

init_stored_proc_names = [
    'create_roles',
    'create_categories',
    'create_users',
    'create_stores',
    'create_products',
    'init_roles',
    'init_categories',
    'init_users',
    'init_stores',
    'init_products'
]

other_stored_procs = [
    os.path.join('.', 'stored_proc', 'insert_user.sql'),
    os.path.join('.', 'stored_proc', 'insert_category.sql'),
    os.path.join('.', 'stored_proc', 'insert_category_no_image.sql'),
    os.path.join('.', 'stored_proc', 'insert_store.sql'),
    os.path.join('.', 'stored_proc', 'insert_product.sql'),
    os.path.join('.', 'stored_proc', 'select_roles.sql'),
    os.path.join('.', 'stored_proc', 'select_users.sql'),
    os.path.join('.', 'stored_proc', 'get_category.sql'),
    os.path.join('.', 'stored_proc', 'get_categories.sql'),
    os.path.join('.', 'stored_proc', 'get_product.sql'),
    os.path.join('.', 'stored_proc', 'get_products_by_store.sql'),
    os.path.join('.', 'stored_proc', 'validate_user.sql'),
    os.path.join('.', 'stored_proc', 'validate_store_name.sql'),
    os.path.join('.', 'stored_proc', 'get_user.sql'),
    os.path.join('.', 'stored_proc', 'get_store.sql'),
    os.path.join('.', 'stored_proc', 'get_product_by_id.sql')
]

other_stored_proc_names = [
    'select_roles',
    'select_users',
    'validate_user',
    'validate_store_name',
    'insert_users',
    'insert_category',
    'insert_category_no_image',
    'insert_store',
    'insert_product',
    'get_category',
    'get_categories',
    'get_product',
    'get_products_by_store',
    'get_user',
    'get_store',
    'get_product_by_id'
]

# run create db procedure first
print "creating the database..."
os.system(import_base_str + os.path.join('.', 'stored_proc', 'create_db.sql'))
os.system(run_base_str + "-e \"call create_db()\"")

# import all init procedures
for proc in init_stored_procs:
    print "importing: ", proc
    os.system(import_base_str + proc)

# import all other procedures
for proc in other_stored_procs:
    print "importing: ", proc
    os.system(import_base_str + proc)

# call all init procedures
for proc in init_stored_proc_names:
    print "calling: ", proc
    os.system(run_base_str +  "-e \"call " + proc + "()\"")
